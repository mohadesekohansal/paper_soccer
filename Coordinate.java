public class Coordinate {

	
	int x;
	int y;

	public Coordinate(int x , int y) {
		// TODO Auto-generated constructor stub
		this.x = x ;
		this.y = y;
		
	}
	
	public void update(Coordinate cord ,int i, int j) {
		// TODO Auto-generated method stub
		cord.x = cord.x + i*57 ;
		cord.y = cord.y + j*57 ;

		
	}
	
	
}
