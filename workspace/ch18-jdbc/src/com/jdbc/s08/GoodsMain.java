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
		super("상품관리");

		dao = new GoodsDao();

		//테이블 생성
		String[] colNames = {"코드", "상품명", "가격", "제조사"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0) {
			@Override						//row    column
			public boolean isCellEditable(int r, int c) {
				//테이블 편집 가능 여부 설정
				if(c == 0) {
					//코드 수정 불가능
					return false; //code에 해당하는 컬럼
				}else {
					//상품명, 가격, 제조사는 수정가능
					return true; //그 외에 해당하는 컬럼
				}
			}
		};

		table = new JTable(model);
		//컬럼 재배치 금지
		table.getTableHeader().setReorderingAllowed(false);

		//Table을 JFrame에 등록
		add(new JScrollPane(table), BorderLayout.CENTER);
		//window의 x버튼을 클릭하면 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		text1 = new JTextField(4);
		text2 = new JTextField(4);
		text3 = new JTextField(4);
		text4 = new JTextField(4);

		bInsert = new JButton("추가");
		bUpdate = new JButton("수정");
		bDelete = new JButton("삭제");
		bList = new JButton("목록");

		panel.add(new JLabel("코드"));
		panel.add(text1);
		panel.add(new JLabel("상품명"));
		panel.add(text2);
		panel.add(new JLabel("가격"));
		panel.add(text3);
		panel.add(new JLabel("제조사"));
		panel.add(text4);

		panel.add(bInsert);
		panel.add(bUpdate);
		panel.add(bDelete);
		panel.add(bList);

		//JPanel을 JFrame에 등록
		add(panel,BorderLayout.SOUTH);

		//이벤트 소스와 이벤트 리스너 연결
		bInsert.addActionListener(this);
		bUpdate.addActionListener(this);
		bDelete.addActionListener(this);
		bList.addActionListener(this);

		//		   x   y  width height
		setBounds(300,300,700,300);
		//JFrame 노출 여부 지정
		setVisible(true);
		
		//목록 바로보이게
		listInfo();

	}

	public static void main(String[] args) {
		new GoodsMain();
	}

	//이벤트 핸들러 구현
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();

		if(name.equals("추가")) {
			insertInfo();
		}else if(name.equals("수정")) {
			updateInfo();
		}else if(name.equals("삭제")) {
			deleteInfo();
		}else if(name.equals("목록")) {
			listInfo();
		}
	}

	//데이터 추가
	private void insertInfo() {
		Goods goods = new Goods();

		try {
		goods.setCode(text1.getText());
		goods.setName(text2.getText());
		goods.setPrice(Integer.parseInt(text3.getText()));
		goods.setMaker(text4.getText());
		}catch(Exception e) {
			showMsg("값 입력이 누락되었습니다.");
		}

		int count = dao.insertInfo(goods);

		if(count <= 0) {
			showMsg("등록 실패");
		}else {
			showMsg(count + "개 등록 성공");
		}
		//입력창 초기화
		text1.setText("");
		text2.setText("");
		text3.setText("");
		text4.setText("");

		//코드 입력창에 포커스 주기
		text1.requestFocus();
		
		listInfo();
	}
	//데이터 목록
	private void listInfo() {
		ArrayList<Goods> list = dao.listInfo();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//데이터 초기화		
		model.setRowCount(0);
		//DB에서 읽어온 데이터를 행단위로 table에 표시

		for(Goods goods : list) {
			String[] data = { goods.getCode(), goods.getName(), 
					String.valueOf(goods.getPrice()), goods.getMaker() };
			
			model.addRow(data);
		}

	}
	//데이터 수정
	private void updateInfo() {
		//선택한 행의 정보를 배열로 반환
		int row[] = table.getSelectedRows();
		if(row.length <= 0) {
			System.out.println("수정할 레코드를 선택하세요.");
			return ;
		}
		
		//수정이 완료되지 않은 데이터를 강제로 수정 완료시킴
		if(table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		
		//ArrayList 생성
		ArrayList<Goods> list = new ArrayList<Goods>();
		for(int i=0;i<row.length;i++) {
			if(table.getValueAt(row[i], 0) == null) {
				//코드값이 없는 경우는 코드 skip
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
			showMsg("수정 실패");
			return;
		}else {
			showMsg(count + "개의 행 수정 성공");
		}
		//목록 호출
		listInfo();
	}
	//데이터 삭제
	private void deleteInfo() {
		int row[] = table.getSelectedRows();
		if(row.length <= 0) {
			System.out.println("삭제할 레코드를 선택하세요.");
			return ;
		}
		//행번호와 매칭되는 code 구하기
		String code[] = new String[row.length];
		for(int i=0;i<row.length; i++) {
			if(table.getValueAt(row[i], 0) == null) {
				continue;
			}
			code[i] = table.getValueAt(row[i], 0).toString();
		}
		//레코드 삭제
		int count = dao.deleteInfo(code);
		if(count <= 0) {
			showMsg("삭제 실패");
			return;
		}else {
			showMsg(count + "개의 행 삭제 성공");
		}
		
		listInfo();
	}
	
	//경고창
	private void showMsg(String str) {
		JOptionPane.showMessageDialog(this, str, "안내 메세지", JOptionPane.INFORMATION_MESSAGE);
	}

}
