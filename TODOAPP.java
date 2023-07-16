import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TODOAPP extends JFrame
{
    private  ArrayList<String> task;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public TODOAPP()
    {
        task = new ArrayList<>();
        listModel = new DefaultListModel<>();

        setTitle("TODO APP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel(" Name:");
        JTextField nameField = new JTextField(20);
        JButton addButton  = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        setLayout( new FlowLayout());
        add(nameLabel);
        add(nameField);
        add(addButton);
        add(deleteButton);
        add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = nameField.getText();
                if (!taskName.isEmpty())
                {
                    task.add(taskName);
                    updateTaskList();
                    nameField.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1)
                {
                    task.remove(selectedIndex);
                    updateTaskList();
                }
            }
        });
    }

    private void updateTaskList(){
        listModel.clear();
        for (String task: task){
            listModel.addElement(task);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TODOAPP todoapp = new TODOAPP();
                todoapp.setVisible(true);
            }
        });
    }
}
