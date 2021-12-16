import { useState, useEffect } from 'react'
import { useParams } from "react-router";
import { useNavigate } from 'react-router-dom';

import api from "../services/api"

function FormFornecedor() {

  const [nome, setNome] = useState("")

  const params = useParams();
  const navigate = useNavigate();

  const fornecedorId = params.id === undefined ? null : params.id;

  useEffect(() => {
    if(fornecedorId){
    api.get(`/fornecedores/${fornecedorId}`).then(res => {
      setNome(res.data.nome)
    });
  }}, [fornecedorId])


  function onSubmit(e) {
    e.preventDefault();
    if(fornecedorId !== null) {
      api.put(`/fornecedores/${fornecedorId}`, {
        fornecedorId,
        nome,
      } ).then(() => {
          alert('Cadastro atualizado com sucesso!');
          navigate('/');
          
      }).catch((e) => {
          alert(e.response.data.message);
      })
    } else {
      api.post('/fornecedores', {
        nome,
      } ).then(() => {
          alert('Cadastro realizado com sucesso!');
          navigate('/');
          
      }).catch((error) => {
        alert(error.response.data.message);
      })
    }
  }

  return (
    <div className="container">
      <div className="row">
        <form onSubmit={onSubmit}>
          <div className="mt-3 mb-3">
            <label className="form-label">Nome do Fornecedor</label>
            <input 
              className="form-control" 
              name="nome" 
              label="Nome completo" 
              value={nome} 
              onChange={(e)=>{setNome(e.target.value)}}
              type="text"
              required
            />
            </div>
              <button id="btn-cadastrar" className="btn btn-primary" type="submit">Cadastrar</button>
          </form>
      </div>
    </div>
  )
}

export default FormFornecedor;