import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.fop.svg.PDFTranscoder;

public class svg2pdf {

	public static void main(String[] args) {
		try {
			if (args.length < 2)
				return;
			
			String svgFile = args[0];
			String pdfFile = args[1]; 
			
	        //Step -1: We read the input SVG document into Transcoder Input
	        String svg_URI_input = Paths.get(svgFile).toUri().toURL().toString();
	        TranscoderInput input_svg_image = new TranscoderInput(svg_URI_input);        
	        //Step-2: Define OutputStream to PDF file and attach to TranscoderOutput
	        OutputStream pdf_ostream = new FileOutputStream(pdfFile);
	        TranscoderOutput output_pdf_file = new TranscoderOutput(pdf_ostream);               
	        // Step-3: Create a PDF Transcoder and define hints
	        Transcoder transcoder = new PDFTranscoder();
	        // Step-4: Write output to PDF format
	        transcoder.transcode(input_svg_image, output_pdf_file);
	        // Step 5- close / flush Output Stream
			pdf_ostream.flush();
			pdf_ostream.close();  
		} catch (IOException | TranscoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
