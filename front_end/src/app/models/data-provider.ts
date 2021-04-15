export class DataProvider {
    currentPage: number;
    pageSize: number;
    totalResults: number;
    offset: number;
    startRow:number;
    sortFields:string;
    sortDirections:string;
    search:string = '';
    constructor() {
        
    }
}
