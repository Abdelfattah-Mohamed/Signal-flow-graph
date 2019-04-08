package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import logic.MyGraph;

public class results implements Initializable{
	
	@FXML
	private ListView<String> results_listView ;
	
	@FXML
	private Label result_label ;
	
	private MyGraph graph_obj = input_screen.getGraphobj();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		results_listView.getItems().add("Forward paths");
		//forward pathes "forward path k is x1x2x3... with gain = gain"
		ArrayList<ArrayList<Integer>> list = graph_obj.getPath().getPaths();
		
		// individual loop k is x1x2.. with gain = gain
		results_listView.getItems().add("individual loops");
		
		// m-non touched loops 
			//1- x1x2.. and x1x2... 
		results_listView.getItems().add("m non touched loops");
		
		// delta = ()
		results_listView.getItems().add("delta");
		
		
		// delta m = ()
		results_listView.getItems().add("deltas");
		
		
		// final result 
		results_listView.getItems().add("result");
		
		
	}
	
	
	

}
