import { Component, OnInit } from '@angular/core';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import {ServiceService} from "../Service/service.service";

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.scss'],

})
export class ListaComponent implements OnInit {

  listaP: Array<any> = [];
  codigob: number;
  codigo: string;
  descripcion: string;
  precio: string;
  cantidad: string;
  total: string;
  constructor(private serviceLogin: ServiceService) { }

  ngOnInit() {
  }

  oncodigo(event: any) {
    this.codigob = event.target.value;
  }


  buscarp() {


    this.serviceLogin.getProducto(this.codigob).subscribe((value: any) => {
      this.listaP = value;
      this.codigo = JSON.stringify(this.listaP["codigo"]);
      this.descripcion = JSON.stringify(this.listaP["descripcion"]);
      this.precio = JSON.stringify(this.listaP["precio"]);
      this.cantidad = JSON.stringify(this.listaP["cantidad"]);
      this.total = JSON.stringify(this.listaP["total"]);

      return;
    });
/*
    window.alert(this.codigob);
    this.serviceLogin.getProducto(this.codigob).subscribe((data: {}) => {
      this.listaP = Object.keys(data).map(i => data[i]);
      this.codigo = this.listaP["codigo"];
      this.descripcion = this.listaP["descripcion"];
      window.alert(JSON.stringify(data));
      window.alert(this.codigo);
      window.alert(this.descripcion);
    });
*/

  }


}
