import java.util.concurrent.CyclicBarrier;

 class E2 extends Production {
 E2(Vertex Vert,CyclicBarrier Barrier){
 super(Vert,Barrier);
 }
 Vertex apply(Vertex T) {
 System.out.println("E2");
 //implement production E2 here
 //...
 return T;
 }
 }