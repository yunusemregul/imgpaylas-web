import React, { useState } from "react";
import Header from "../components/Header";
import DivBackground from "../components/DivBackground";
import Input from "../components/Input";
import axios from "axios";

const marginTop = { marginTop: "20px" };

export default function Register() {
  function handleSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const body = {};
    formData.forEach((value, property) => (body[property] = value));
    axios.post("/api/v1/user/register", formData).then((response) => {
      if (response.status == 200) {
        axios.post("/perform_login", formData).then(() => {
          window.location.href = "/home";
        });
      }
    });
  }

  return (
    <div className="box">
      <Header />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center" onSubmit={handleSubmit}>
            <label className="form-label">Kayıt Ol</label>
            <br />
            <Input type="text" placeholder="Ad" id="name" style={marginTop} />
            <br />
            <Input
              type="text"
              placeholder="E-posta"
              id="email"
              autoFocus={true}
              style={marginTop}
            />
            <br />
            <Input
              type="password"
              placeholder="Şifre"
              id="password"
              style={marginTop}
            />
            <br />
            <Input
              type="password"
              placeholder="Şifre Tekrarı"
              id="password_again"
              style={marginTop}
            />
            <br />
            <button className="button" style={marginTop}>
              Kayıt Ol
            </button>
          </form>
        </div>
      </DivBackground>
    </div>
  );
}
