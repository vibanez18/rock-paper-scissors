import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Game } from './game';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseUrl = 'http://localhost:8080/api/v1/start';

  constructor(private http: HttpClient) { }

  play(game: Game) {
    return this.http.post<Game>(`${this.baseUrl}`, game);
  }
}
