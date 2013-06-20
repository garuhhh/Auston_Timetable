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


public class MainWindow {
	private static Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shlAustonTimetable = new Shell();
		shlAustonTimetable.setMaximized(true);
		shlAustonTimetable.setMinimumSize(new Point(800, 600));
		shlAustonTimetable.setSize(765, 451);
		shlAustonTimetable.setText("Auston Timetable");
		shlAustonTimetable.setLayout(new FormLayout());
		
		Menu menu = new Menu(shlAustonTimetable, SWT.BAR);
		shlAustonTimetable.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmnew = new MenuItem(menu_1, SWT.NONE);
		mntmnew.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/sun/java/swing/plaf/windows/icons/File.gif"));
		mntmnew.setText("&New...");
		
		MenuItem mntmopen = new MenuItem(menu_1, SWT.NONE);
		mntmopen.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif"));
		mntmopen.setText("&Open...");
		
		MenuItem mntmdelete = new MenuItem(menu_1, SWT.NONE);
		mntmdelete.setText("&Delete...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmsave = new MenuItem(menu_1, SWT.NONE);
		mntmsave.setImage(SWTResourceManager.getImage(MainWindow.class, "/javax/swing/plaf/metal/icons/ocean/floppy.gif"));
		mntmsave.setText("&Save");
		
		MenuItem mntmSaveas = new MenuItem(menu_1, SWT.NONE);
		mntmSaveas.setImage(SWTResourceManager.getImage(MainWindow.class, "/javax/swing/plaf/metal/icons/ocean/floppy.gif"));
		mntmSaveas.setText("Save &As...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmprint = new MenuItem(menu_1, SWT.NONE);
		mntmprint.setText("&Print...");
		
		MenuItem mntmexport = new MenuItem(menu_1, SWT.NONE);
		mntmexport.setText("&Export...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setImage(SWTResourceManager.getImage(MainWindow.class, "/javax/swing/plaf/metal/icons/ocean/close.gif"));
		mntmExit.setText("E&xit");
		
		MenuItem mntmedit = new MenuItem(menu, SWT.CASCADE);
		mntmedit.setText("&Edit");
		
		Menu menu_3 = new Menu(mntmedit);
		mntmedit.setMenu(menu_3);
		
		MenuItem mntmUndo = new MenuItem(menu_3, SWT.NONE);
		mntmUndo.setText("&Undo");
		
		MenuItem mntmRedo = new MenuItem(menu_3, SWT.NONE);
		mntmRedo.setText("&Redo");
		
		MenuItem mntmhelp = new MenuItem(menu, SWT.CASCADE);
		mntmhelp.setText("&Help");
		
		Menu menu_2 = new Menu(mntmhelp);
		mntmhelp.setMenu(menu_2);
		
		MenuItem mntmaboutAustontimetable = new MenuItem(menu_2, SWT.NONE);
		mntmaboutAustontimetable.setText("&About AustonTimetable");
		
		Composite composite = new Composite(shlAustonTimetable, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(100, -45);
		fd_composite.bottom = new FormAttachment(100, -10);
		fd_composite.left = new FormAttachment(100, -774);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		
		
		Button btnOk = new Button(composite, SWT.NONE);
		btnOk.setBounds(608, 10, 75, 25);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnOk.setText("&Ok");
		
		Button btnCancel = new Button(composite, SWT.CENTER);
		btnCancel.setBounds(689, 10, 75, 25);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCancel.setText("Ca&ncel");
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shlAustonTimetable, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.bottom = new FormAttachment(composite, -6);
		fd_scrolledComposite.right = new FormAttachment(composite, 0, SWT.RIGHT);
		fd_scrolledComposite.left = new FormAttachment(0, 10);
		fd_scrolledComposite.top = new FormAttachment(0, 10);
		scrolledComposite.setLayoutData(fd_scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		table = new Table(scrolledComposite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		scrolledComposite.setContent(table);
		scrolledComposite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		btnOk.setFocus();

		shlAustonTimetable.open();
		shlAustonTimetable.layout();
		while (!shlAustonTimetable.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
