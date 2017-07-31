package headBall;
	
	import java.awt.Point;
	import java.awt.geom.Ellipse2D;
	import java.awt.geom.Rectangle2D;
	
	public class GamePhysic {
		private int delay;
		private boolean isGoal = false;
		
		//private final int WIDTH = 1286, HEIGHT = 800;
		public boolean checkXSides( Ball ball ) {
			return (ball.getBallX() <= 124 && ball.getBallY()< 556 ) || (ball.getBallX() >= 1130&& ball.getBallY()< 556);
		}
		
		public boolean playerRCollision(Ellipse2D.Double e, Rectangle2D.Double rectR) {
			
			return e.intersects(rectR);

		}

		public boolean playerLCollision(Ellipse2D.Double e, Rectangle2D.Double rectL) {
			return e.intersects(rectL);
		}
	
		public boolean isGoal(){
			return isGoal;
		}
		
		public boolean checkYSides( Ball ball ) {
			
			return ball.getBallY() <= 55 || ball.getBallY() >= 556;
	
		}
		public void setDelay(int delay) {
			this.delay = delay;
		}
		public int getDelay() {
			return this.delay;
		}
	
		
		public boolean ballCollision(Ellipse2D.Double e, Rectangle2D.Double rectL)
		{
			return e.intersects(rectL);
		}
		 
		public boolean checkGoal1(Ball ball, Goal goalLeft) {
			return ball.getBallX() >= 1130;
		}
		
		public boolean checkGoal2(Ball ball, Goal goalLeft) {
			return ball.getBallX() <= 124;
		}
		
		public void ballMotion(Ball ball) {
			ball.setBallX(ball.getBallX()+ ball.getSpeedX());
			ball.setBallY(ball.getBallY()+ ball.getSpeedY());
		}
	}