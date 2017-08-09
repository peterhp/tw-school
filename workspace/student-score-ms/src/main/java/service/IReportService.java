package service;

import model.Report;
import exception.InvalidStudentIdsFormatException;
import exception.UnexistedStudentException;

/**
 * Created by Shli on 07/08/2017.
 */
public interface IReportService {
    Report genReport(String ids) throws InvalidStudentIdsFormatException, UnexistedStudentException;
}
