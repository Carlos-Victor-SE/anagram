import { Component } from '@angular/core';
import { AnagramService } from './app-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { TableModule } from 'primeng/table';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule, NgxPaginationModule, TableModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  constructor(public service: AnagramService) {}

  public word: string = '';
  public anagrams: string[] = [];
  public page: number = 0;
  public pageSize: number = 30;
  public totalRecords: number = 0;

  /*
   * getAnagram envia a requisição para o service para que possa receber os anagramas do backend.
  */
  getAnagrams() {
    this.service.getAnagrams(this.word, this.page, this.pageSize).subscribe(response => {
      this.anagrams = response.data;
      this.totalRecords = response.total; 
    });
  }

  /*
   * Metodo que muda pagina, como não esta completo todas as funcionalidades da paginação.
   * ocorre o erro em que a contagem de pagina é infinita enquanto clicar para passar não chega em um limite correto.
   * varias paginas fazias serão mostradas por conta desse erro.
  */
  changePage(event: any) {
    this.page = event.first / this.pageSize;
    this.getAnagrams();
  }

  /*
   * allowOnlyLetters é usado para limitar a escrita para letras apenas, so limita escrita pelo teclado.
   * não fiz a validação para impedir copiar e colar caracteres especiais então ele ainda passa caracteres dessa forma por essa validação.
  */
  allowOnlyLetters(event: KeyboardEvent) {
    const regex = /^[a-zA-Z]$/;
    if (!regex.test(event.key)) {
      event.preventDefault();
    }
  }

}
