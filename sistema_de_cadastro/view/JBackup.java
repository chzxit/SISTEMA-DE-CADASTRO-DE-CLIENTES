package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class JBackup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<String> arquivosBackup;
	private String[] nomesBackup;
	private Backup backup;
	private String itemSelecionado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JBackup frame = new JBackup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JBackup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 770, 207);
		contentPane.add(scrollPane);

		backup = new Backup();
		arquivosBackup = new ArrayList<>();
		arquivosBackup = backup.listarArquivos();
		nomesBackup = arquivosBackup.toArray(new String[arquivosBackup.size()]);
		
		JList list = new JList();
		list.setListData(nomesBackup);
		
		scrollPane.setViewportView(list);
		JButton btnNewButton_1 = new JButton("Gerar Backup");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnNewButton_1,
						"Deseja gerar o backup? ") == JOptionPane.YES_NO_OPTION) {
					backup.gerarBackup();
					arquivosBackup = backup.listarArquivos();
					nomesBackup = arquivosBackup.toArray(new String[arquivosBackup.size()]);
					list.setListData(nomesBackup);
					revalidate();
					repaint();
				}
			}
		});
		btnNewButton_1.setBounds(10, 227, 117, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("Restaurar Backup");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnNewButton_1,
						"Deseja restaurar o backup? ") == JOptionPane.YES_NO_OPTION) {
					try {
						
						backup.restaurarBackup(itemSelecionado);
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(176, 227, 145, 23);
		contentPane.add(btnNewButton);

		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					if(list.getSelectedIndex() == -1) {
						list.setSelectedIndex(e.getFirstIndex());
						
					}
					itemSelecionado = ((JList<String>)e.getSource()).getSelectedValue();
					if(itemSelecionado != null) {
						btnNewButton.setEnabled(true);
						
					}
				}
				
			}
		});
	}
}
