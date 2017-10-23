import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Executor extends Thread {
	public synchronized void run() {
		Vertex S = new Vertex(null, null, null, "S");
		try {
			// [(P1)]
			CyclicBarrier barrier = new CyclicBarrier(1);
			P1 p1 = new P1(S, barrier);
			p1.start();
			barrier.await();
			// [(P2)1(P2)2]
			barrier = new CyclicBarrier(2);
			P2 p2a = new P2(p1.m_vertex.m_left, barrier);
			P2 p2b = new P2(p1.m_vertex.m_right, barrier);
			p2a.start();
			p2b.start();
			barrier.await();
			// [(P3)1(P3)2(P3)3(P3)4]
			barrier = new CyclicBarrier(4);
			P2 p3a = new P2(p2a.m_vertex.m_left, barrier);
			P2 p3b = new P2(p2a.m_vertex.m_right, barrier);
			P3 p3c = new P3(p2b.m_vertex.m_left, barrier);
			P3 p3d = new P3(p2b.m_vertex.m_right, barrier);
			p3a.start();
			p3b.start();
			p3c.start();
			p3d.start();
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}