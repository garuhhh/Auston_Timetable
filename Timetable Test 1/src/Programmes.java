import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;


public class Programmes {
	private static Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlAustonTimetable = new Shell();
		shlAustonTimetable.setImage(SWTResourceManager.getImage(Programmes.class, "/com/sun/java/swing/plaf/windows/icons/JavaCup32.png"));
		shlAustonTimetable.setMaximized(true);
		shlAustonTimetable.setMinimumSize(new Point(800, 600));
		shlAustonTimetable.setSize(765, 451);
		shlAustonTimetable.setText("Programmes and Universities");
		shlAustonTimetable.setLayout(new FormLayout());
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shlAustonTimetable, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.top = new FormAttachment(0, 10);
		fd_scrolledComposite.left = new FormAttachment(0, 10);
		fd_scrolledComposite.right = new FormAttachment(100, -10);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		Composite composite = new Composite(shlAustonTimetable, SWT.NONE);
		fd_scrolledComposite.bottom = new FormAttachment(composite, -6);
		FormData fd_composite = new FormData();
		fd_composite.left = new FormAttachment(100, -774);
		fd_composite.top = new FormAttachment(100, -35);
		fd_composite.bottom = new FormAttachment(100, -10);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setBounds(689, 0, 75, 25);
		btnCancel.setText("&Cancel");
		
		Button btnok = new Button(composite, SWT.NONE);
		btnok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnok.setBounds(608, 0, 75, 25);
		btnok.setText("&Close");

		shlAustonTimetable.open();
		shlAustonTimetable.layout();
		while (!shlAustonTimetable.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
