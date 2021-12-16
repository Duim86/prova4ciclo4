import { useState, useEffect } from 'react'
import { useParams } from "react-router";
import Header from "../components/Header"
import api from '../services/api';

function DetalhesTipoProduto() {
  const params = useParams();

  const [tipoProduto, setTipoProduto] = useState({
    nome: "",
    produtoLista: []
  })
  

  useEffect(() => {
    api.get(`/tiposProduto/${params.id}`).then(res => {
      setTipoProduto(res.data)
    });
  }, [params.id]) 

  return (
    <>
    <Header />
      <main>
        <div className="container mt-4">
            <div className="row">
                <div className="col-12">
                    <p><b>Nome:</b> <span>{tipoProduto.nome}</span></p>
                </div>
            </div>
            <div className="row">
                <div className="col-12">
                    <a className="btn btn-primary mt-5" href={`/tiposProduto/editar/${params.id}`}>Editar</a>
                </div>
            </div>
        </div>
      </main>
    </>
  )
}

export default DetalhesTipoProduto
