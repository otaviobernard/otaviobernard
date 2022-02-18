package View;

public interface IView {

    public void showMessage(String msg);

    public int askForInt(String question);

    public double askForDouble(String question);

    public String askForString(String question);

    public Long askForLong(String question);
    
}