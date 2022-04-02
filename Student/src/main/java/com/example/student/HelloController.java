package com.example.student;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnMoveBack;

    @FXML
    private Button btnMoveForward;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnShow;

    @FXML
    private Button btnSkipBack;

    @FXML
    private Button btnSkipForward;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAttendanceEG;

    @FXML
    private TableColumn<?, ?> colAttendancePoints;

    @FXML
    private TableColumn<?, ?> colAttendanceScore;

    @FXML
    private TableColumn<?, ?> colExamEG;

    @FXML
    private TableColumn<?, ?> colExamPoints;

    @FXML
    private TableColumn<?, ?> colExamScore;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colGrade;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colPracticalEG;

    @FXML
    private TableColumn<?, ?> colPracticalPoints;

    @FXML
    private TableColumn<?, ?> colPracticalScore;

    @FXML
    private TableColumn<?, ?> colProjectEG;

    @FXML
    private TableColumn<?, ?> colProjectPoints;

    @FXML
    private TableColumn<?, ?> colProjectScore;

    @FXML
    private TableColumn<?, ?> colRemarks;

    @FXML
    private TableColumn<?, ?> colStudentID;

    @FXML
    private TableColumn<?, ?> colWrittenEG;

    @FXML
    private TableColumn<?, ?> colWrittenPoints;

    @FXML
    private TableColumn<?, ?> colWrittenScore;

    @FXML
    private TextField tfAttendanceEG;

    @FXML
    private TextField tfAttendancePoints;

    @FXML
    private TextField tfAttendanceScore;

    @FXML
    private TextField tfExamEG;

    @FXML
    private TextField tfExamPoints;

    @FXML
    private TextField tfExamScore;

    @FXML
    private TextField tfFirstName;

    @FXML
    private TextField tfGrade;

    @FXML
    private TextField tfLastName;

    @FXML
    private TextField tfPracticalEG;

    @FXML
    private TextField tfPracticalPoints;

    @FXML
    private TextField tfPracticalScore;

    @FXML
    private TextField tfProjectEG;

    @FXML
    private TextField tfProjectPoints;

    @FXML
    private TextField tfProjectScore;

    @FXML
    private TextField tfRemark;

    @FXML
    private TextField tfStudentID;

    @FXML
    private TextField tfWrittenEG;

    @FXML
    private TextField tfWrittenPoints;

    @FXML
    private TextField tfWrittenScore;
    @FXML
    private TableView<Student> tvMain;


    private ObservableList<Student> Data;


    @FXML
    public void initialize() {

        makeTextFieldNumber(tfAttendanceScore);
        makeTextFieldNumber(tfExamScore);
        makeTextFieldNumber(tfPracticalScore);
        makeTextFieldNumber(tfWrittenScore);
        makeTextFieldNumber(tfProjectScore);

        PropertyValueFactory facFirstName = new PropertyValueFactory<Student, String>("FirstName");
        colFirstName.setCellValueFactory(facFirstName);
        PropertyValueFactory facLastName = new PropertyValueFactory<Student, String>("LastName");
        colLastName.setCellValueFactory(facLastName);
        PropertyValueFactory facStudentId = new PropertyValueFactory<Student, String>("Id");
        colStudentID.setCellValueFactory(facStudentId);

        PropertyValueFactory facAttendanceEG = new PropertyValueFactory<Student, Double>("AttendanceEG");
        colAttendanceEG.setCellValueFactory(facAttendanceEG);
        PropertyValueFactory facAttendanceScore = new PropertyValueFactory<Student, Double>("AttendanceScore");
        colAttendanceScore.setCellValueFactory(facAttendanceScore);
        PropertyValueFactory facAttendancePoints = new PropertyValueFactory<Student, Double>("AttendancePoints");
        colAttendancePoints.setCellValueFactory(facAttendancePoints);

        PropertyValueFactory facWrittenEG = new PropertyValueFactory<Student, Double>("WrittenEG");
        colWrittenEG.setCellValueFactory(facWrittenEG);
        PropertyValueFactory facWrittenScore = new PropertyValueFactory<Student, Double>("WrittenScore");
        colWrittenScore.setCellValueFactory(facWrittenScore);
        PropertyValueFactory facWrittenPoints = new PropertyValueFactory<Student, Double>("WrittenPoints");
        colWrittenPoints.setCellValueFactory(facWrittenPoints);

        PropertyValueFactory facPracticalEG = new PropertyValueFactory<Student, Double>("PracticalEG");
        colPracticalEG.setCellValueFactory(facPracticalEG);
        PropertyValueFactory facPracticalScore = new PropertyValueFactory<Student, Double>("PracticalScore");
        colPracticalScore.setCellValueFactory(facPracticalScore);
        PropertyValueFactory facPracticalPoints = new PropertyValueFactory<Student, Double>("PracticalPoints");
        colPracticalPoints.setCellValueFactory(facPracticalPoints);

        PropertyValueFactory facProjectEG = new PropertyValueFactory<Student, Double>("ProjectEG");
        colProjectEG.setCellValueFactory(facProjectEG);
        PropertyValueFactory facProjectScore = new PropertyValueFactory<Student, Double>("ProjectScore");
        colProjectScore.setCellValueFactory(facProjectScore);
        PropertyValueFactory facProjectPoints = new PropertyValueFactory<Student, Double>("ProjectPoints");
        colProjectPoints.setCellValueFactory(facProjectPoints);

        PropertyValueFactory facExamEG = new PropertyValueFactory<Student, Double>("ExamEG");
        colExamEG.setCellValueFactory(facExamEG);
        PropertyValueFactory facExamScore = new PropertyValueFactory<Student, Double>("ExamScore");
        colExamScore.setCellValueFactory(facExamScore);
        PropertyValueFactory facExamPoints = new PropertyValueFactory<Student, Double>("ExamPoints");
        colExamPoints.setCellValueFactory(facExamPoints);

        PropertyValueFactory facGrade = new PropertyValueFactory<Student, Double>("PrelimGrade");
        colGrade.setCellValueFactory(facGrade);
        PropertyValueFactory facRemarks = new PropertyValueFactory<Student, String>("Remark");
        colRemarks.setCellValueFactory(facRemarks);

        StringProperty attendanceScore = tfAttendanceScore.textProperty();
        StringProperty attendanceEG = tfAttendanceEG.textProperty();
        DoubleProperty subTotal = new SimpleDoubleProperty();
        DoubleProperty subTotal1 = new SimpleDoubleProperty();

        StringProperty writtenScore = tfWrittenScore.textProperty();
        StringProperty writtenEG = tfWrittenEG.textProperty();
        DoubleProperty subWritten = new SimpleDoubleProperty();
        DoubleProperty subWritten1 = new SimpleDoubleProperty();

        StringProperty practicalScore = tfPracticalScore.textProperty();
        StringProperty practicalEG = tfPracticalEG.textProperty();
        DoubleProperty subPractical = new SimpleDoubleProperty();
        DoubleProperty subPractical1 = new SimpleDoubleProperty();

        StringProperty projectScore = tfProjectScore.textProperty();
        StringProperty projectEG = tfProjectEG.textProperty();
        DoubleProperty subProject = new SimpleDoubleProperty();
        DoubleProperty subProject1 = new SimpleDoubleProperty();

        StringProperty examScore = tfExamScore.textProperty();
        StringProperty examEG = tfExamEG.textProperty();
        DoubleProperty subExam = new SimpleDoubleProperty();
        DoubleProperty subExam1 = new SimpleDoubleProperty();


        try {
            subTotal.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(attendanceScore.get());
                double result = calculateEG(score, Student.AttendanceTotal);
                return Double.valueOf(result);
            }, attendanceScore));
            tfAttendanceEG.textProperty().bind(subTotal.asString());
            subTotal1.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(attendanceEG.get());
                double result = calculatePoints(score, Student.AttendancePercentage);
                return Double.valueOf(result);
            }, attendanceEG));
            tfAttendancePoints.textProperty().bind(subTotal1.asString());


            subWritten.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(writtenScore.get());
                double result = calculateEG(score, Student.WrittenTotal);
                return Double.valueOf(result);
            }, writtenScore));
            tfWrittenEG.textProperty().bind(subWritten.asString());
            subWritten1.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(writtenEG.get());
                double result = calculatePoints(score, Student.WrittenPercentage);
                return Double.valueOf(result);
            }, writtenEG));
            tfWrittenPoints.textProperty().bind(subWritten1.asString());


            subPractical.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(practicalScore.get());
                double result = calculateEG(score, Student.PracticalTotal);
                return Double.valueOf(result);
            }, practicalScore));
            tfPracticalEG.textProperty().bind(subPractical.asString());
            subPractical1.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(practicalEG.get());
                double result = calculatePoints(score, Student.PracticalPercentage);
                return Double.valueOf(result);
            }, practicalEG));
            tfPracticalPoints.textProperty().bind(subPractical1.asString());


            subProject.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(projectScore.get());
                double result = calculateEG(score, Student.ProjectTotal);
                return Double.valueOf(result);
            }, projectScore));
            tfProjectEG.textProperty().bind(subProject.asString());
            subProject1.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(projectEG.get());
                double result = calculatePoints(score, Student.ProjectPercentage);
                return Double.valueOf(result);
            }, projectEG));
            tfProjectPoints.textProperty().bind(subProject1.asString());


            subExam.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(examScore.get());
                double result = calculateEG(score, Student.ExamTotal);
                return Double.valueOf(result);
            }, examScore));
            tfExamEG.textProperty().bind(subExam.asString());

            subExam1.bind(Bindings.createDoubleBinding(() -> {
                Double score = Double.parseDouble(examEG.get());
                double result = calculatePoints(score, Student.ExamPercentage);
                return Double.valueOf(result);
            }, examScore));
            tfExamPoints.textProperty().bind(subExam1.asString());

        } catch (NumberFormatException e) {
            return;
        }


//        ObservableList column = tvMain.getColumns();
//
//        column.forEach(n->{
//            PropertyValueFactory fac = new PropertyValueFactory()
//            n.
//        });


//        StringProperty amountCharged = txtAmountCharged.textProperty();
//        StringProperty phoneUse = txtPhoneUse.textProperty();
//        DoubleProperty subTotal = new SimpleDoubleProperty();
//
//        try {
//            subTotal.bind(Bindings.createDoubleBinding(() -> {
//                return Double.sum(Double.parseDouble(amountCharged.get()), Double.parseDouble(phoneUse.get()));
//            }, amountCharged, phoneUse));
//
//            txtSubTotal.textProperty().bind(subTotal.asString());
//
//
//        } catch (NumberFormatException e) {
//            return;
//        }
//        txtSubTotal.textProperty().bindBidirectional(((Property)subTotal.getBean()));

    }


    private double calculateEG(double score, double total) {
        return (100 / total) * score;
    }

    private double calculatePoints(double eg, double percentage) {
        return (eg / 100) * percentage;
    }


    public void Init(ObservableList<Student> data) {
        Data = data;
    }


    private void makeTextFieldNumber(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("^[1-9]\\d*(\\.\\d+)?$")) {
                    textField.setText(newValue.replaceAll("[^[1-9]\\d*(\\.\\d+)?$]", ""));
                }
            }
        });

    }

    @FXML
    void onClickbtnClear(ActionEvent event) {
        tfAttendanceScore.setText("");
        tfExamScore.setText("");
        tfWrittenScore.setText("");
        tfPracticalScore.setText("");
        tfProjectScore.setText("");
    }

    private void compute() {
        try {
            double practical = Double.valueOf(Double.parseDouble(tfPracticalPoints.getText()));
            double exam = Double.valueOf(Double.parseDouble(tfExamPoints.getText()));
            double project = Double.valueOf(Double.parseDouble(tfProjectPoints.getText()));
            double attendance = Double.valueOf(Double.parseDouble(tfAttendancePoints.getText()));
            double written = Double.valueOf(Double.parseDouble(tfWrittenPoints.getText()));

            double PrelimGrade = practical + exam + project + attendance + written;
            String Remark;
            if (PrelimGrade < 60) {
                Remark = "FAILED";
            } else {
                Remark = "Passed";
            }


            tfGrade.setText(String.valueOf(PrelimGrade));
            tfRemark.setText(Remark);
        } catch (NumberFormatException e) {
            return;
        }
    }

    @FXML
    void onClickbtnCompute(ActionEvent event) {
        compute();


    }

    @FXML
    void onClickbtnDelete(ActionEvent event) {
        Student student = tvMain.getSelectionModel().getSelectedItem();
        Data.remove(student);

    }

    @FXML
    void onClickbtnExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onClickbtnLoad(ActionEvent event) {
        tvMain.setItems(Data);
    }

    @FXML
    void onClickbtnMoveBack(ActionEvent event) {
        int i = tvMain.getSelectionModel().getSelectedIndex();
        if(i == 0){
            return;
        }
        tvMain.getSelectionModel().select(i -1);

    }

    @FXML
    void onClickbtnMoveForward(ActionEvent event) {
        int i = tvMain.getSelectionModel().getSelectedIndex();
        if(i == Data.size()){
            return;
        }
        tvMain.getSelectionModel().select(i + 1);
    }

    @FXML
    void onClickbtnSave(ActionEvent event) {
        if (tfStudentID.getText() == null) {
            return;
        }

        double practical = Double.valueOf(Double.parseDouble(tfPracticalScore.getText()));
        double exam = Double.valueOf(Double.parseDouble(tfExamScore.getText()));
        double project = Double.valueOf(Double.parseDouble(tfProjectScore.getText()));
        double attendance = Double.valueOf(Double.parseDouble(tfAttendanceScore.getText()));
        double written = Double.valueOf(Double.parseDouble(tfWrittenScore.getText()));
        Student student = new Student(tfStudentID.getText(), tfFirstName.getText(), tfLastName.getText(), attendance, written, practical, project, exam);
        compute();
        Data.add(student);

    }

    @FXML
    void onClickbtnShow(ActionEvent event) {
        Student student = tvMain.getSelectionModel().getSelectedItem();
        tfStudentID.setText(student.getId());
        tfFirstName.setText(student.getFirstName());
        tfLastName.setText(student.getLastName());
        tfRemark.setText(student.getRemark());
        tfGrade.setText(String.valueOf(student.getPrelimGrade()));
        tfPracticalScore.setText(String.valueOf(student.getPracticalScore()));
        tfWrittenScore.setText(String.valueOf(student.getWrittenScore()));
        tfExamScore.setText(String.valueOf(student.getExamScore()));
        tfProjectScore.setText(String.valueOf(student.getProjectScore()));
        tfAttendanceScore.setText(String.valueOf(student.getAttendanceScore()));


    }

    @FXML
    void onClickbtnSkipBackbtnSkipBack(ActionEvent event) {

        tvMain.getSelectionModel().select(0);


    }

    @FXML
    void onClickbtnSkipForward(ActionEvent event) {
        tvMain.getSelectionModel().select(Data.size()-1);
    }

    @FXML
    void onClickbtnUpdate(ActionEvent event) {
        String id = tfStudentID.getText().toString();

        for (int i = 0; i < Data.size(); i++) {
            if (Data.get(i).getId().equals(id)) {

                double practical = Double.valueOf(Double.parseDouble(tfPracticalScore.getText()));
                double exam = Double.valueOf(Double.parseDouble(tfExamScore.getText()));
                double project = Double.valueOf(Double.parseDouble(tfProjectScore.getText()));
                double attendance = Double.valueOf(Double.parseDouble(tfAttendanceScore.getText()));
                double written = Double.valueOf(Double.parseDouble(tfWrittenScore.getText()));
                Student student = new Student(tfStudentID.getText(), tfFirstName.getText(), tfLastName.getText(), attendance, written, practical, project, exam);
                Data.set(i, student);
            } else {
                System.out.println("notfound!" + id);
            }
        }
        compute();

    }


}
