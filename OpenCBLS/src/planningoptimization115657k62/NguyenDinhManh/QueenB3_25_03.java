import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

public class QueenB3_25_03 {
	public void solve(int n)
	{
		Model model = new Model("Queen");
		IntVar[] x = new IntVar[n];
		IntVar[] d1  = new IntVar[n];
		IntVar[] d2  = new IntVar[n];

		for(int i = 0; i < n; i++) {
			x[i] = model.intVar("X" + i, 1, n); // đây là hàm mục tiêu
			d1[i] = model.intOffsetView(x[i], i);
			d2[i] = model.intOffsetView(x[i], -i);
		}
	        model.allDifferent(x).post();
	        model.allDifferent(d1).post();
	        model.allDifferent(d2).post();
	        
	        model.getSolver().solve();
	        for(int i=10; i<n; i++) {
	        	System.out.println("x[" + i + "]" + x[i].getValue());
	        }
	}
	
	public static void main(String[] args) {
		QueenB3_25_03 app =   new QueenB3_25_03();
		app.solve(50);
	        
	}
}
