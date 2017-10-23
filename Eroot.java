import java.util.concurrent.CyclicBarrier;

 class Eroot extends Production {
 Eroot(Vertex Vert,CyclicBarrier Barrier){
 super(Vert,Barrier);
 }
 Vertex apply(Vertex T) {
 System.out.println("Eroot");
 //implement production E3 here
 return T;
 }
 }
