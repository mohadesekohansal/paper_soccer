
public class Coordinate {

	
	int x;
	int y;

	public Coordinate(int x , int y) {
		// TODO Auto-generated constructor stub
		this.x = x ;
		this.y = y;
		
	}
	
	public Coordinate location(){
		Coordinate cord = new Coordinate(x, y);
		System.out.println("["+x+","+y+"]");
		return cord ;
	}
	
	
}
