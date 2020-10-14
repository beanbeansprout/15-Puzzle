import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Puzzle extends JPanel implements ActionListener, KeyListener {
	
	ArrayList<Piece> pieceList = new ArrayList<Piece>();
	Timer t = new Timer(1, this); /*adds a new timer*/
	Blank b = new Blank(3, 3);
	boolean isMoving = false;
	
	public Puzzle() {
		
		t.start();
		addKeyListener(this);
		setFocusable(true);
		
		initLists();
		
	}
	
	public static void main (String[] args) {
		
		JFrame frame = new JFrame("15 Puzzle");
		frame.setSize(512, 512);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Puzzle p = new Puzzle();
		frame.add(p); /*adds the puzzle class to the screen*/
		
	}
	
	public void initLists() {
	
		pieceList.add(new Piece(0, 0, 1));
		pieceList.add(new Piece(1, 0, 2));
		pieceList.add(new Piece(2, 0, 3));
		pieceList.add(new Piece(3, 0, 4));
		pieceList.add(new Piece(0, 1, 5));
		pieceList.add(new Piece(1, 1, 6));
		pieceList.add(new Piece(2, 1, 7));
		pieceList.add(new Piece(3, 1, 8));
		pieceList.add(new Piece(0, 2, 9));
		pieceList.add(new Piece(1, 2, 10));
		pieceList.add(new Piece(2, 2, 11));
		pieceList.add(new Piece(3, 2, 12));
		pieceList.add(new Piece(0, 3, 13));
		pieceList.add(new Piece(1, 3, 14));
		pieceList.add(new Piece(2, 3, 15));
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g); /*parent class which will get rid of some problems*/
		
		for (int i = 0; i < pieceList.size(); i++) {
			
			g.drawRect(pieceList.get(i).x * 64, pieceList.get(i).y * 64, 64, 64); /*draws 15 rectangles to the screen using each piece's x and y values*/
			g.drawString("" + pieceList.get(i).number, pieceList.get(i).x * 64 + 32, pieceList.get(i).y * 64 + 32); /*adds a number to each piece and centers it*/
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		repaint();
	
	}
	
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode(); /*stores the key pressed in "code" variable*/
		
		if (code == KeyEvent.VK_UP) {
			
			/*move pieces up*/
			for (int i = 0; i < pieceList.size(); i++) {
				
				if (pieceList.get(i).y - 1 == b.y && pieceList.get(i).x == b.x) {
					
					pieceList.get(i).y--;
					isMoving = true;
					
				}
				
			}
			
			if (isMoving) {
				
				b.y++;
				isMoving = false;
				
			}
			
		}
		
		if (code == KeyEvent.VK_DOWN) {
			
			/*move pieces down*/
			for (int i = 0; i < pieceList.size(); i++) {
				
				if (pieceList.get(i).y + 1 == b.y && pieceList.get(i).x == b.x) {
					
					pieceList.get(i).y++;
					isMoving = true;
					
				}
				
			}
			
			if (isMoving) {
				
				b.y--;
				isMoving = false;
				
			}
			
		}
		
		if (code == KeyEvent.VK_LEFT) {
			
			/*move pieces left*/
			for (int i = 0; i < pieceList.size(); i++) {
				
				if (pieceList.get(i).x - 1 == b.x && pieceList.get(i).y == b.y) {
					
					pieceList.get(i).x--;
					isMoving = true;
					
				}
				
			}
			
			if (isMoving) {
					
				b.x++;
				isMoving = false;
					
			}
			
		}
		
		if (code == KeyEvent.VK_RIGHT) {
			
			/*move pieces right*/
			for (int i = 0; i < pieceList.size(); i++) {
				
				if (pieceList.get(i).x + 1 == b.x && pieceList.get(i).y == b.y) {
					
					pieceList.get(i).x++;
					isMoving = true;
					
				}
				
			}
			
			if (isMoving) {
					
				b.x--;
				isMoving = false;
					
			}
			
		}
		
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {} /*if these other methods are not here it will cause problems*/
	
}

class Piece {
		
		public int x;
		public int y;
		public int number;
		
		public Piece(int x, int y, int number) {

			this.x = x;
			this.y = y;
			this.number = number;
			
		}

}

class Blank {
	
	public int x;
	public int y;
	
	public Blank(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
}

