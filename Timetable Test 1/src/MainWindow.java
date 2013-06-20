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
		shlAustonTimetable.setImage(SWTResourceManager.getImage(MainWindow.class, "/javax/swing/plaf/basic/icons/JavaCup16.png"));
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
		
		MenuItem mntmview = new MenuItem(menu, SWT.CASCADE);
		mntmview.setText("&View");
		
		Menu menu_4 = new Menu(mntmview);
		mntmview.setMenu(menu_4);
		
		MenuItem mntmLecturers = new MenuItem(menu_4, SWT.NONE);
		mntmLecturers.setText("Lecturers");
		
		MenuItem mntmRooms = new MenuItem(menu_4, SWT.NONE);
		mntmRooms.setText("Rooms");
		
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
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shlAustonTimetable, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		FormData fd_scrolledComposite = new FormData();
		fd_scrolledComposite.bottom = new FormAttachment(100, -10);
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

		shlAustonTimetable.open();
		shlAustonTimetable.layout();
		while (!shlAustonTimetable.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
