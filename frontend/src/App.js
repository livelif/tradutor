import React from 'react';
import api from './services/api'

import './App.css';

import logo from './assets/logo.png'

function App() {
  return (
    <div className="container">
      <img src={logo} alt="Spargi - Tradutor"/>

      <div className="content">
        <p>
          Traduza <strong>palavras desconhecidas</strong> para o portugues de forma <strong>rapida e eficiente!</strong>
        </p>

        <form>
          <label htmlFor="text">Palavra:</label>
          <input 
            type="text" 
            id="palavra" 
            placeholder="Digite a palavra a ser traduzida"
          />

          <button className="btn" type="submit">Traduzir</button>
        </form>
      </div>
    </div>
  );
}

export default App;
