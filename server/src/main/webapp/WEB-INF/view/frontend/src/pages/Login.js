import React, { useState } from "react";
import { withRouter } from "react-router";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import Input from "../components/Input";
import axios from "axios";

const marginTop = { marginTop: "20px" };

function Login(props) {
  const [error, setError] = useState("");

  function handleSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.target);

    axios
      .post("/api/v1/auth/login", formData)
      .then((result) => {
        if (result.status == 200) {
          setError(""); // probably not needed
          window.location.href = "/home";
        }
      })
      .catch((error) => {
        setError("E-posta ya da şifre geçersiz!");
      });
  }

  return (
    <div className="box">
      <Header />
      <DivBackground>
        <div className="center-vertical-parent">
          <form className="center" onSubmit={handleSubmit}>
            <label className="form-label">Giriş Yap</label>
            <br />
            {error.length > 0 && (
              <>
                <div style={{ marginTop: "15px", marginBottom: "5px" }}>
                  <label className="form-label-small form-label-error">
                    {error}
                  </label>
                </div>
              </>
            )}
            <Input
              type="text"
              placeholder="E-posta"
              id="email"
              autoFocus={true}
              style={marginTop}
              error={error.length > 0}
            />
            <br />
            <Input
              type="password"
              placeholder="Şifre"
              id="password"
              style={marginTop}
              error={error.length > 0}
            />
            <br />
            <button className="button" style={marginTop}>
              Giriş
            </button>
          </form>
        </div>
        <div className="absolute-centerx form-label-small">
          Hesabın yok mu? <a href="/register">Kayıt Ol</a>
        </div>
      </DivBackground>
    </div>
  );
}

export default withRouter(Login);
