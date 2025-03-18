import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

interface AnagramResponse {
  data: string[];
  total: number;
}

@Injectable({
  providedIn: 'root',
})
export class AnagramService {
  private apiUrl = 'http://localhost:8080/anagram/get';

  constructor(private http: HttpClient) {}

  /*
   * Metodo responsável por fazer a requisição http para o backend e receber os anagramas e a paginação.
  */
  getAnagrams(word: string, page: number, size: number): Observable<AnagramResponse> {
    return this.http.get<AnagramResponse>(`${this.apiUrl}?word=${word}&page=${page}&size=${size}`);
  }
}