package headBall;

public class ArtificialInteligence extends Player {
	
	private static final long serialVersionUID = 1L;
	
	public boolean timeToJump(Ball ball, Player player){
		return ( ball.getBallY() - 200 ) < player.getY() && Math.abs(ball.getBallX() - player.getX()) <200;
	}
	public boolean timeToLeft(Ball ball, Player player){
		return  (ball.getBallX()  < player.getX()) && (ball.getBallX() - player.getX()) < 0;
	}
	public boolean timeToRight(Ball ball, Player player){
		return ( ball.getBallX()  > player.getX()) && ((ball.getBallX() - player.getX()) > 0);
	}
	public boolean timeToStop() {
		return Main.game.isAI();
	}
	
}
