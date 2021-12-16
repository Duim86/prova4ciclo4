import {useState, useEffect } from "react"
import Header from "../components/Header"
import Table from "../components/Table"
import api from "../services/api"


function FornecedorPage() {
  const [fornecedores, setFornecedores] = useState([])

  useEffect(() => {
    api.get('/fornecedores')
        .then(res => setFornecedores(res.data));
  }, [])

  const removerFornecedor = (fornecedorId) => {
    api.delete(`/fornecedores/${fornecedorId}`).then(() => {
      alert('Registro removido com sucesso!');
      window.location.reload()
      
    }).catch(() => {
        alert('Erro ao remover!');
    })
  }

  return (
    <>
      <Header />
      <Table 
        name = 'fornecedor'
        listEntity = {fornecedores}        
        remover = {removerFornecedor}
        buttonText = "Novo Fornecedor"
      />
    </>    
  )
}

export default FornecedorPage