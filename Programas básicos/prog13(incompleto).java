import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class FactInt extends Applet implements ActionListener{
    public void actionPerfomed(ActionEvent event){
        int value;
        value = Integer.parseInt(inputField.getText());
        inputField.setText("");
        outLabel.setText(value + " factorial is " + factorial(value));

    }
    private int factorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return(n*factorial(n-1));
        }
    }
    private static TextField inputField;
    private static Label label;
    private static Label outLabel;
    private static Button button;

    public void init(){
        label = new Label("Enter an Integer: " + "press Enter.");
        outLabel = new Label("Answer");
        button = new Button("Enter");
        button.addActionListener(this);
        inputField = new TextField("Value here");
        add(label);
        add(inputField);
        add(button);
        add(outLabel);
        setLayout(new GridLayout(4,1));
    }
}
