package com.example.student;

public class Student {
    private String Id;
    private String FirstName;
    private String LastName;
    private double AttendanceScore;
    private double AttendanceEG;
    private double AttendancePoints;
    private double WrittenScore;
    private double WrittenEG;
    private double WrittenPoints;
    private double PracticalScore;
    private double PracticalEG;
    private double PracticalPoints;
    private double ProjectScore;
    private double ProjectEG;
    private double ProjectPoints;
    private double ExamScore;
    private double ExamEG;
    private double ExamPoints;
    private double PrelimGrade;
    private String Remark;

    public double getPrelimGrade() {
        return PrelimGrade;
    }

    public void setPrelimGrade(double prelimGrade) {
        PrelimGrade = prelimGrade;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    static public double AttendanceTotal = 20;
    static public double WrittenTotal = 50;
    static public double PracticalTotal = 50;
    static public double ProjectTotal = 100;
    static public double ExamTotal = 100;

    static public double AttendancePercentage = 10;
    static public double WrittenPercentage = 10;
    static public double PracticalPercentage = 20;
    static public double ProjectPercentage = 30;
    static public double ExamPercentage = 30;


    public Student(String id, String firstName, String lastName, double attendanceScore, double writtenScore, double practicalScore, double projectScore, double examScore) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;

        AttendanceScore = attendanceScore;
        AttendanceEG = calculateEG(AttendanceScore, AttendanceTotal);
        AttendancePoints = calculatePoints(AttendanceEG, AttendancePercentage);

        WrittenScore = writtenScore;
        WrittenEG = calculateEG(WrittenScore, WrittenTotal);
        WrittenPoints = calculatePoints(WrittenEG, WrittenPercentage);

        PracticalScore = practicalScore;
        PracticalEG = calculateEG(PracticalScore, PracticalTotal);
        PracticalPoints = calculatePoints(PracticalEG, PracticalPercentage);

        ProjectScore = projectScore;
        ProjectEG = calculateEG(ProjectScore, ProjectTotal);
        ProjectPoints = calculatePoints(ProjectEG, ProjectPercentage);

        ExamScore = examScore;
        ExamEG = calculateEG(ExamScore, ExamTotal);
        ExamPoints = calculatePoints(ExamEG, ExamPercentage);

        this.reCalculate();
    }

    public void reCalculate(){
        PrelimGrade = AttendancePoints+WrittenPoints+PracticalPoints+ProjectPoints+ExamPoints;

        if(PrelimGrade < 60){
            Remark = "FAILED";
        }else{
            Remark = "Passed";
        }
    }

    private double calculateEG(double score, double total){
        return (100/total)*score;
    }

    private double calculatePoints(double eg, double percentage){
        return (eg/100)*percentage;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getAttendanceScore() {
        return AttendanceScore;
    }

    public void setAttendanceScore(double attendanceScore) {
        AttendanceScore = attendanceScore;
        AttendanceEG = calculateEG(AttendanceScore, AttendanceTotal);
        AttendancePoints = calculatePoints(AttendanceEG, AttendancePercentage);
    }

    public double getAttendanceEG() {
        return AttendanceEG;
    }

    public void setAttendanceEG(double attendanceEG) {
        AttendanceEG = attendanceEG;
        AttendancePoints = calculatePoints(AttendanceEG, AttendancePercentage);
    }

    public double getAttendancePoints() {
        return AttendancePoints;
    }

    public void setAttendancePoints(double attendancePoints) {
        AttendancePoints = attendancePoints;
    }

    public double getWrittenScore() {
        return WrittenScore;
    }

    public void setWrittenScore(double writtenScore) {
        WrittenScore = writtenScore;
        WrittenEG = calculateEG(WrittenScore, WrittenTotal);
        WrittenPoints = calculatePoints(WrittenEG, WrittenPercentage);
    }

    public double getWrittenEG() {
        return WrittenEG;
    }

    public void setWrittenEG(double writtenEG) {
        WrittenEG = writtenEG;
        WrittenPoints = calculatePoints(WrittenEG, WrittenPercentage);
    }

    public double getWrittenPoints() {
        return WrittenPoints;
    }

    public void setWrittenPoints(double writtenPoints) {
        WrittenPoints = writtenPoints;
    }

    public double getPracticalScore() {
        return PracticalScore;
    }

    public void setPracticalScore(double practicalScore) {
        PracticalScore = practicalScore;
        PracticalEG = calculateEG(PracticalScore, PracticalTotal);
        PracticalPoints = calculatePoints(PracticalEG, PracticalPercentage);
    }

    public double getPracticalEG() {
        return PracticalEG;
    }

    public void setPracticalEG(double practicalEG) {
        PracticalEG = practicalEG;
        PracticalPoints = calculatePoints(PracticalEG, PracticalPercentage);
    }

    public double getPracticalPoints() {
        return PracticalPoints;
    }

    public void setPracticalPoints(double practicalPoints) {
        PracticalPoints = practicalPoints;
    }

    public double getProjectScore() {
        return ProjectScore;

    }

    public void setProjectScore(double projectScore) {
        ProjectScore = projectScore;
        ProjectEG = calculateEG(ProjectScore, ProjectTotal);
        ProjectPoints = calculatePoints(ProjectEG, ProjectPercentage);
    }

    public double getProjectEG() {
        return ProjectEG;
    }

    public void setProjectEG(double projectEG) {
        ProjectEG = projectEG;
        ProjectPoints = calculatePoints(ProjectEG, ProjectPercentage);
    }

    public double getProjectPoints() {
        return ProjectPoints;
    }

    public void setProjectPoints(double projectPoints) {
        ProjectPoints = projectPoints;
    }

    public double getExamScore() {
        return ExamScore;
    }

    public void setExamScore(double examScore) {
        this.ExamScore = examScore;
        ExamEG = calculateEG(ExamScore, ExamTotal);
        ExamPoints = calculatePoints(ExamEG, ExamPercentage);
    }

    public double getExamEG() {
        return ExamEG;
    }

    public void setExamEG(double examEG) {
        this.ExamEG = examEG;
        ExamPoints = calculatePoints(ExamEG, ExamPercentage);
    }

    public double getExamPoints() {
        return ExamPoints;
    }

    public void setExamPoints(double examPoints) {
        this.ExamPoints = examPoints;
    }
}
