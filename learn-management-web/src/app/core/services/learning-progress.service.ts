import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LEARN_API} from '../../app.api';
import {LearningProgress} from '../../model/learning-progress';

@Injectable({
  providedIn: 'root'
})
export class LearningProgressService {
  constructor(private http: HttpClient) {}

  save(learningProgress: LearningProgress): Observable<LearningProgress> {
    return this.http.post<LearningProgress>(`${LEARN_API}/learning-progresses`, learningProgress);
  }

  findByStudentUserName(studentUserName: string): Observable<LearningProgress[]> {
    return this.http.get<LearningProgress[]>(`${LEARN_API}/learning-progresses/student?studentUserName=${studentUserName}`);
  }

  update(learningProgress: LearningProgress): Observable<LearningProgress> {
    return this.http.put<LearningProgress>(`${LEARN_API}/learning-progresses/${learningProgress.id}`, learningProgress);
  }
}
