import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;


public class ModuleEditor extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ModuleEditor(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(577, 300);
		shell.setText(getText());
		
		Label lblModuleNamePlaceholder = new Label(shell, SWT.NONE);
		lblModuleNamePlaceholder.setBounds(10, 10, 233, 15);
		lblModuleNamePlaceholder.setText("Module Code Placeholder");	//put in the Module Code in this text
		
		Label lblModuleNamePlaceholder_1 = new Label(shell, SWT.NONE);
		lblModuleNamePlaceholder_1.setText("Module Name Placeholder");	//put in the Module Name in this text
		lblModuleNamePlaceholder_1.setBounds(10, 31, 233, 15);
		
		Label lblPleaseSelectThe = new Label(shell, SWT.NONE);
		lblPleaseSelectThe.setBounds(10, 73, 531, 15);
		lblPleaseSelectThe.setText("Please select the Programmes (and the corresponding University) to which this Module is offered:");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(10, 94, 551, 23);
		
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(10, 123, 551, 23);
		
		Combo combo_4 = new Combo(shell, SWT.NONE);
		combo_4.setBounds(10, 152, 551, 23);
		
		Combo combo_6 = new Combo(shell, SWT.NONE);
		combo_6.setBounds(10, 181, 551, 23);
		
		Button btncancel = new Button(shell, SWT.NONE);
		btncancel.setBounds(486, 237, 75, 25);
		btncancel.setText("&Cancel");
		
		Button btnsave = new Button(shell, SWT.NONE);
		btnsave.setBounds(405, 237, 75, 25);
		btnsave.setText("&Save");

	}

}
