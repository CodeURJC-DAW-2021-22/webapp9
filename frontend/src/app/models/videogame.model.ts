export interface Videogame {
    id?: number;
    imageVg: boolean;
    imageCompany: boolean;
	  title: string;
    price:number;
    rating:number;
    genre:string;
    company:string;
    continent:string;
    description:string;
    shortDescription:string;
    history:string;

    cpuR:string;
    ramR:string;
    ssooR:string;
    gpuR:string;
    storageR:string;

    cpuM:string;
    ramM:string;
    ssooM:string;
    gpuM:string;
    storageM:string;
}
