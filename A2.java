import java.util.concurrent.CyclicBarrier;

 class A2 extends Production {
 A2(Vertex Vert,CyclicBarrier Barrier){
 super(Vert,Barrier);
 }
 Vertex apply(Vertex T) {
 System.out.println("A2");
 //implement production A2 here
 ...
 return T;
 }
 }