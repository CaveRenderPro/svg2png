import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

public class svg2png {

	public static void main(String[] args) {
		try {
			if (args.length < 2)
				return;
			
			String svgFile = args[0];
			String pngFile = args[1]; 
			
	        //Step -1: We read the input SVG document into Transcoder Input
	        String svg_URI_input = Paths.get(svgFile).toUri().toURL().toString();
	        TranscoderInput input_svg_image = new TranscoderInput(svg_URI_input);        
	        //Step-2: Define OutputStream to PDF file and attach to TranscoderOutput
	        OutputStream png_ostream = new FileOutputStream(pngFile);
	        TranscoderOutput output_png_file = new TranscoderOutput(png_ostream);               
	        // Step-3: Create a PNG Transcoder and define hints
	        Transcoder transcoder = new PNGTranscoder();
	        // Step-4: Write output to PDF format
	        transcoder.transcode(input_svg_image, output_png_file);
	        // Step 5- close / flush Output Stream
			png_ostream.flush();
			png_ostream.close();  
		} catch (IOException | TranscoderException e) {
			e.printStackTrace();
		}
	}

}
