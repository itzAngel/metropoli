import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import * as uuid from 'uuid';
import { Agente } from 'src/app/models/agente';
import { Contacto } from 'src/app/models/contacto';
import { Propiedad } from 'src/app/models/propiedad';
import { ContactanosService } from '../../../page/contactanos/contactanos.service';
import { PropiedadService } from '../../inmueble/propiedad/propiedad.service';
import { LoginService } from '../login/login.service';
// For MDB Angular Pro
import { CarouselModule, WavesModule } from 'ng-uikit-pro-standard'
import { Tipo } from 'src/app/models/tipo';
import { Estado } from 'src/app/models/estado';
import { Ubicacion } from 'src/app/models/ubicacion';
import { TipoService } from '../../basicos/tipo/tipo.service';
import { UbicacionService } from '../../basicos/ubicacion/ubicacion.service';
import { EstadoService } from '../../basicos/estado/estado.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  agente: Agente = new Agente();
  nombre: string = '';
  imagen: string = null;
  animInterval;
  propiedades: Propiedad[] = [];
  tipos:Tipo[]=[];
  estados:Estado[]=[];
  ubicaciones:Ubicacion[]=[];
  /*paginacion*/
  page_size: number = 3;
  page_number: number = 1;
  /*contacto*/
  contacto: Contacto = new Contacto();
  variableMuestra: string = null;

  /*slider*/
  images = [
    { path: '../../../../assets/img/adondevivir-200.png' },
    { path: '../../../../assets/img/hol-200-e1608013721107.png' },
    { path: '../../../../assets/img/laencontre-200.png' },
    { path: '../../../../assets/img/net4house-200-e1608013745279.png' },
    { path: '../../../../assets/img/nexo-agentes-blanco.png' },
    { path: '../../../../assets/img/olx-200-e1608013700526.png' },
    { path: '../../../../assets/img/Properati-200.png' },
  ];


  index = 0;
  avatars = '12345'.split('').map((x, i) => {
    return {
      url: `https://picsum.photos/600/400/?${i}`,
      title: `${i}`
    };
  })

  constructor(public contactoservice: ContactanosService, public service: LoginService, public router: Router,
    public propiedadService: PropiedadService, private _snackBar: MatSnackBar,public tipoService: TipoService,
    public estadoService: EstadoService,public ubicacionService: UbicacionService) { }

  chunk(arr, chunkSize) {
    let R = [];
    for (let i = 0, len = arr.length; i < len; i += chunkSize) {
      R.push(arr.slice(i, i + chunkSize));
    }
    return R;
  }
  ngOnInit(): void {
    if (this.service.agente != null) {
      this.agente = this.service.agente;
      this.nombre = this.agente.nombre;
    } else {
      this.nombre = "";
    }
    this.startAnim();
    this.cargarPropiedades();
    this.cargarCombos();
  }
  openSnackBar(mensaje: string) {
    this._snackBar.open(mensaje, 'OK', {
      duration: 1000,
      horizontalPosition: "center",
      verticalPosition: "top",
    });
  }
  /*funciones de validacion*/
  validar() {
    if (this.contacto.nombre != null && this.contacto.celular != null &&
      this.contacto.correo != null && this.contacto.mensaje != null) {
      return true;
    } else {
      return false;
    }
  }

  /*funciones crud*/
  limpiar() {
    this.contacto = new Contacto();
  }

  EnviarForm() {
    if (this.validar()) {
      this.contacto.idContacto = uuid().replace(/-/g, '');//asigna id cliente
      this.contactoservice.create(this.contacto).subscribe(data => {
        this.openSnackBar("Su formulario se agrego con exito");
        this.contacto = new Contacto();
      });
    } else {
      this.openSnackBar("Llena todos los campos del formulario");
    }
  }

  cargarCombos(): void{
    this.tipoService.getList().subscribe(data=>{
      this.tipos=data;
    });
    this.estadoService.getList().subscribe(data=>{
      this.estados=data;
    });
    this.ubicacionService.getList().subscribe(data=>{
      this.ubicaciones=data;
    });
  }

  cargarPropiedades(): void {
    this.propiedadService.getList().subscribe(data => {
      this.propiedades = data;
      for (var i = 0; i < this.propiedades.length; i++) {
        for (var j = 0; j < this.propiedades.length; j++) {
          if (this.propiedades[j].fechaIngreso > this.propiedades[i].fechaIngreso) {
            var aux: Propiedad;
            aux = this.propiedades[j];
            this.propiedades[j] = this.propiedades[i];
            this.propiedades[i] = aux;
          }
        }
      }
    });
  }
  /*funciones de filtros y busqueda*/
  handlePage(e: PageEvent) {
    this.page_size = e.pageSize;
    this.page_number = e.pageIndex + 1;
  }
  Prop() {
    this.router.navigate(["propiedad"]);
  }
  PropBusqueda(){
    this.propiedadService.busquedaBarra=true;
    this.router.navigate(["propiedad"]);
  }
  Contacto() {
    this.router.navigate(["contactanos"]);
  }

  startAnim() {
    let añosMercado = document.getElementById('añosMercado');
    let clientesCartera = document.getElementById('clientesCartera');
    let propiedadesGestionadas = document.getElementById('propiedadesGestionadas');
    this.animInterval = setInterval(this.animNumValue, 100, añosMercado, 10);
    this.animInterval = setInterval(this.animNumValue, 5, clientesCartera, 1000);
    this.animInterval = setInterval(this.animNumValue, 10, propiedadesGestionadas, 500);
  }

  animNumValue(num, newValue) {
    var valor = num.innerHTML;
    var intValue = parseInt(valor);

    if (intValue >= newValue) { //Si el valor ha superado el objetivo paro
      clearInterval(this.animInterval);
    } else { //Si el valor no ha superado el objetivo lo aumento
      valor++;
      num.innerHTML = valor;
    }
  }
}
