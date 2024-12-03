
    public class DigitalVideoDisc extends Disc implements Playable {
    	public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
            super(id, title, category, cost, length, director);
        }
        public void play() {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
    }

