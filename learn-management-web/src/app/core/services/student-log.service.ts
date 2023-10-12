import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LEARN_API} from '../../app.api';
import {StudentLog} from '../../model/student-log';

@Injectable({
  providedIn: 'root',
})
export class StudentLogService {
  constructor(private http: HttpClient) {}

  save(studentLog: StudentLog): Observable<StudentLog> {
    return this.http.post<StudentLog>(`${LEARN_API}/student-logs`, studentLog);
  }

  findAllByStudentUserName(studentUserName: string): Observable<StudentLog[]> {
    return this.http.get<StudentLog[]>(`${LEARN_API}/student-logs/${studentUserName}`);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${LEARN_API}/student-logs/${id}`);
  }
}
