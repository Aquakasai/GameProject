package IHM;
public class ThrDessin extends Thread {
	private JPnlCombat cbt;
	private boolean shutdown;
	public final static int DT = 100;
	public ThrDessin(JPnlCombat cbt) {
		this.cbt = cbt;
		this.shutdown = false;
	}
	
	public void run()
	{
		while (!this.shutdown)
		{
			try {
				Thread.sleep(DT);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.cbt.repaint();
		}
		
	}
	
	public void setShutdown(boolean b) {
		this.shutdown = b;
	}
}
