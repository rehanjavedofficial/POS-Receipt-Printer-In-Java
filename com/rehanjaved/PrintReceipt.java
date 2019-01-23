package com.rehanjaved;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JOptionPane;

/**
 * @author REHAN JAVED
 * @version 1.0
 * 
 * 
 */
public class PrintReceipt implements Printable {

	// Attributes..
	private PrinterJob printerJob;
	private PageFormat pageFormat; 
	private Paper paper;
	
	private final int MARGIN = 1;
	
	public PrintReceipt() {
		
		printerJob = PrinterJob.getPrinterJob();
		pageFormat = printerJob.defaultPage(); // Getting the page format.

		paper = new Paper(); // Create a new paper..
		
		// If you are working on printer rather than Thermal printers
		// then change the width and height accordingly.
		
		// I set them to 1000 value because that was for 
		// receipt which will not be larger than 1000 points
		// actually this height does not mean the height of 
		// paper get out from the printer, this is the height
		// of the printable area which you can use.
		int width = 216;
		int height = 1000;
		
		// width = totalWidthOfPage - (MARGIN * 2);
		// height = numberOfLines * 10 - (MARGIN * 2);
		
		paper.setImageableArea(MARGIN, MARGIN, width, height);
		pageFormat.setPaper(paper);
		
		pageFormat.setOrientation(PageFormat.PORTRAIT);
		printerJob.setPrintable(this, pageFormat);
		
		try {
			
			printerJob.print();
		
		} catch (PrinterException ex) {
			
			JOptionPane.showMessageDialog(null, "Printing Failed, Error: "+ex.toString());
		
		}
		
	}
	
	/**
	 * 
	 */
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		return 0;
	}

}
