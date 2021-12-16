import React from 'react'

function Table({listEntity, name, remover, idfornecedor, buttonText}) {
  console.log(idfornecedor)
  return (
      <div className="container mt-4">
        <div className="row">
          <div className="col-12">
            <table className="table table-hover">
              <thead>     
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Nome</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody>
              {listEntity.map(entity => {
                return (                
                  <tr key={entity.id}>
                    <th id={`entity-${entity.id}`} className="col-1" scope="row">{entity.id}</th>
                    <td id={`nome-${entity.id}`} className="col-4">{entity.nome}</td>
                    <td id={`detalhes-${entity.id}`} className="col-1"><a className="btn btn-success" href={`/${name}/detalhes/${entity.id}`}>Detalhes</a></td>
                    <td id={`editar-${entity.id}`} className="col-1"><a className="btn btn-secondary" href={`/${name}/editar/${entity.id}`}>Editar</a></td>
                    {remover && 
                      <td id={`remover-${entity.id}`} className="col-1"><button className="btn btn-danger" onClick={(e) => remover(entity.id)}>Deletar</button></td>
                    }
                  </tr>
                )                  
                })}
              </tbody>
            </table>
          </div>
        </div>
        {buttonText && 
          <div className="row">
            <a 
              testid={`btn-novo-${name}`}  
              id={`btn-novo-${name}`} 
              className="btn btn-primary btn-lg d-block" 
              href={idfornecedor !== undefined ? `/fornecedor/${idfornecedor}/novo/produto` : `/${name}/novo`}
            >
                {buttonText}
            </a>
          </div>
        }
      </div>
  )
}

export default Table


