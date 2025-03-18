import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { TableModule } from 'primeng/table';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    NgxPaginationModule,
    TableModule
  ],
  providers: [],
})
export class AppModule {}