import { useState, useEffect } from 'react'
import { useParams } from "react-router";
import Header from "../components/Header"
import Table from '../components/Table';
import api from '../services/api';

function DetalhesFornecedor() {
  const params = useParams();

  const [fornecedor, setFornecedor] = useState({
    nome: "",
  })

  const [produtos, setProdutos] = useState([])

  useEffect(() => {
    api.get(`/fornecedores/${params.id}/produtos`).then(res => {
      setProdutos(res.data)
    });
  }, [params.id]) 
  
 

  useEffect(() => {
    api.get(`/fornecedores/${params.id}`).then(res => {
      setFornecedor(res.data)
    });
  }, [params.id]) 

  return (
    <>
    <Header />
      <main>
        <div className="container mt-4">
            <div className="row">
                <div className="col-12">
                    <p><b>Nome:</b> <span>{fornecedor.nome}</span></p>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <a className="btn btn-primary mt-5" href={`/fornecedor/editar/${params.id}`}>Editar</a>
                </div>
            </div>
        </div>
      </main>
      <Table 
        name = 'produto'
        listEntity = {produtos}
        buttonText="Novo Produto"  
        idfornecedor={params.id}      
      />
    </>
  )
}

export default DetalhesFornecedor
