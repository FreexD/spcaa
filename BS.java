import java.util.concurrent.CyclicBarrier;

class BS extends Production {
	BS(Vertex Vert, CyclicBarrier Barrier) {
		super(Vert, Barrier);
	}

	Vertex apply(Vertex T) {
		System.out.println("BS");
		// implement production BS here
		// ...
		return T;
	}
}