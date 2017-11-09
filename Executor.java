import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

class Executor extends Thread {
	public synchronized void run() {
		Vertex S = new Vertex(null,null,null,"S");
		try {
			//[(P1)]
			CyclicBarrier barrier = new CyclicBarrier(1+1);
			P1 p1 = new P1(S,barrier);
			p1.start();
			barrier.await();
			//[(P2)1(P2)2]
			barrier = new CyclicBarrier(2+1);
			P2 p2a = new P2(p1.m_vertex.m_left,barrier);
			P2 p2b = new P2(p1.m_vertex.m_right,barrier);
			p2a.start();
			p2b.start();
			barrier.await();
			//[(P2)3(P2)4]
			barrier = new CyclicBarrier(2+1);
			P2 p2c = new P2(p2a.m_vertex.m_left,barrier);
			P2 p2d = new P2(p2a.m_vertex.m_right,barrier);
			p2c.start();
			p2d.start();
			barrier.await();
			//[(P2)1(P2)2(P2)3(P2)4(P3)5(P3)6]
			barrier = new CyclicBarrier(6+1);
			P3 p3a = new P3(p2a.m_vertex.m_left,barrier);
			P3 p3b = new P3(p2a.m_vertex.m_right,barrier);
			P3 p3c = new P3(p2c.m_vertex.m_left,barrier);
			P3 p3d = new P3(p2c.m_vertex.m_right,barrier);
			P3 p3e = new P3(p2d.m_vertex.m_left,barrier);
			P3 p3f = new P3(p2d.m_vertex.m_right,barrier);
			p3a.start();
			p3b.start();
			p3c.start();
			p3d.start();
			p3e.start();
			p3f.start();
			barrier.await();
			// MULTI-FRONTAL SOLVER ALGORITHM
			System.out.println("done");
			GraphDrawer drawer = new GraphDrawer();
			drawer.draw(S);

		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}