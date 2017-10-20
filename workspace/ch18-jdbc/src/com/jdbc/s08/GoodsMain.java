package com.jdbc.s08;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GoodsMain extends JFrame implements ActionListener{
	JTable table;
	JTextField text1, text2, text3, text4;
	JButton bInsert, bUpdate, bDelete, bList;
	JPanel panel;

	GoodsDao dao;

	public GoodsMain() {
		super("��ǰ����");

		dao = new GoodsDao();

		//���̺� ����
		String[] colNames = {"�ڵ�", "��ǰ��", "����", "������"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0) {
			@Override						//row    column
			public boolean isCellEditable(int r, int c) {
				//���̺� ���� ���� ���� ����
				if(c == 0) {
					//�ڵ� ���� �Ұ���
					return false; //code�� �ش��ϴ� �÷�
				}else {
					//��ǰ��, ����, ������� ��������
					return true; //�� �ܿ� �ش��ϴ� �÷�
				}
			}
		};

		table = new JTable(model);
		//�÷� ���ġ ����
		table.getTableHeader().setReorderingAllowed(false);

		//Table�� JFrame�� ���
		add(new JScrollPane(table), BorderLayout.CENTER);
		//window�� x��ư�� Ŭ���ϸ� ���α׷� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		text1 = new JTextField(4);
		text2 = new JTextField(4);
		text3 = new JTextField(4);
		text4 = new JTextField(4);

		bInsert = new JButton("�߰�");
		bUpdate = new JButton("����");
		bDelete = new JButton("����");
		bList = new JButton("���");

		panel.add(new JLabel("�ڵ�"));
		panel.add(text1);
		panel.add(new JLabel("��ǰ��"));
		panel.add(text2);
		panel.add(new JLabel("����"));
		panel.add(text3);
		panel.add(new JLabel("������"));
		panel.add(text4);

		panel.add(bInsert);
		panel.add(bUpdate);
		panel.add(bDelete);
		panel.add(bList);

		//JPanel�� JFrame�� ���
		add(panel,BorderLayout.SOUTH);

		//�̺�Ʈ �ҽ��� �̺�Ʈ ������ ����
		bInsert.addActionListener(this);
		bUpdate.addActionListener(this);
		bDelete.addActionListener(this);
		bList.addActionListener(this);

		//		   x   y  width height
		setBounds(300,300,700,300);
		//JFrame ���� ���� ����
		setVisible(true);
		
		//��� �ٷκ��̰�
		listInfo();

	}

	public static void main(String[] args) {
		new GoodsMain();
	}

	//�̺�Ʈ �ڵ鷯 ����
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();

		if(name.equals("�߰�")) {
			insertInfo();
		}else if(name.equals("����")) {
			updateInfo();
		}else if(name.equals("����")) {
			deleteInfo();
		}else if(name.equals("���")) {
			listInfo();
		}
	}

	//������ �߰�
	private void insertInfo() {
		Goods goods = new Goods();

		try {
		goods.setCode(text1.getText());
		goods.setName(text2.getText());
		goods.setPrice(Integer.parseInt(text3.getText()));
		goods.setMaker(text4.getText());
		}catch(Exception e) {
			showMsg("�� �Է��� �����Ǿ����ϴ�.");
		}

		int count = dao.insertInfo(goods);

		if(count <= 0) {
			showMsg("��� ����");
		}else {
			showMsg(count + "�� ��� ����");
		}
		//�Է�â �ʱ�ȭ
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");

		//�ڵ� �Է�â�� ��Ŀ�� �ֱ�
		text1.requestFocus();
		
		listInfo();
	}
	//������ ���
	private void listInfo() {
		ArrayList<Goods> list = dao.listInfo();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//������ �ʱ�ȭ		
		model.setRowCount(0);
		//DB���� �о�� �����͸� ������� table�� ǥ��

		for(Goods goods : list) {
			String[] data = { goods.getCode(), goods.getName(), 
					String.valueOf(goods.getPrice()), goods.getMaker() };
			
			model.addRow(data);
		}

	}
	//������ ����
	private void updateInfo() {
		//������ ���� ������ �迭�� ��ȯ
		int row[] = table.getSelectedRows();
		if(row.length <= 0) {
			System.out.println("������ ���ڵ带 �����ϼ���.");
			return ;
		}
		
		//������ �Ϸ���� ���� �����͸� ������ ���� �Ϸ��Ŵ
		if(table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		
		//ArrayList ����
		ArrayList<Goods> list = new ArrayList<Goods>();
		for(int i=0;i<row.length;i++) {
			if(table.getValueAt(row[i], 0) == null) {
				//�ڵ尪�� ���� ���� �ڵ� skip
				continue;
			}
			Goods goods = new Goods();
			goods.setCode(table.getValueAt(row[i], 0).toString());
			goods.setName(table.getValueAt(row[i], 1).toString());
			goods.setPrice(Integer.parseInt(table.getValueAt(row[i], 2).toString()));
			goods.setMaker(table.getValueAt(row[i], 3).toString());
			
			list.add(goods);
		}
		int count = dao.updateInfo(list);
		if(count <= 0) {
			showMsg("���� ����");
			return;
		}else {
			showMsg(count + "���� �� ���� ����");
		}
		//��� ȣ��
		listInfo();
	}
	//������ ����
	private void deleteInfo() {
		int row[] = table.getSelectedRows();
		if(row.length <= 0) {
			System.out.println("������ ���ڵ带 �����ϼ���.");
			return ;
		}
		//���ȣ�� ��Ī�Ǵ� code ���ϱ�
		String code[] = new String[row.length];
		for(int i=0;i<row.length; i++) {
			if(table.getValueAt(row[i], 0) == null) {
				continue;
			}
			code[i] = table.getValueAt(row[i], 0).toString();
		}
		//���ڵ� ����
		int count = dao.deleteInfo(code);
		if(count <= 0) {
			showMsg("���� ����");
			return;
		}else {
			showMsg(count + "���� �� ���� ����");
		}
		
		listInfo();
	}
	
	//���â
	private void showMsg(String str) {
		JOptionPane.showMessageDialog(this, str, "�ȳ� �޼���", JOptionPane.INFORMATION_MESSAGE);
	}

}
