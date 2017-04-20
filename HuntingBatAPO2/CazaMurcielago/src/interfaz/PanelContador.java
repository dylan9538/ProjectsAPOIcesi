package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.*;

public class PanelContador extends JPanel {

	private JLabel labCazados, labCaza, labPerdidos, labPer;

	public PanelContador() {

		setLayout(new GridLayout(3, 2));
		labCazados = new JLabel("Cazados:");
		labCaza = new JLabel("0");
		labCaza.setFont(new Font("Arial", 100, 55));

		labPerdidos = new JLabel("Perdidos:");
		labPer = new JLabel("0");
		labPer.setFont(new Font("Arial", 100, 55));

		add(labCazados);
		add(labCaza);
		add(new JLabel());
		add(new JLabel());
		add(labPerdidos);
		add(labPer);

	}

	// Métodos de refresco de informacion.
	public void refrecarCazados(String caza) {
		labCaza.setText(caza);
	}

	public void refrecarPerdidos(String perdido) {
		labPer.setText(perdido);
	}
}
