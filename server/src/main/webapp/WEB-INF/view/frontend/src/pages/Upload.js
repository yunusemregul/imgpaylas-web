import React from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import Input from "../components/Input";
import axios from "axios";

export default function Upload() {
  function handleSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.target);

    axios
      .put("/api/v1/image/upload", formData)
      .then((result) => {
        if (result.status === 200) {
          console.log(result);
        }
      })
      .catch((error) => {
        console.log(error);
      });
  }

  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Yeni Yükleme" />
      <DivBackground backgroundColor="#444">
        <form style={{ margin: "20px" }} onSubmit={handleSubmit}>
          <Input type="file" id="image" />
          <br />
          <Input type="text" id="description" />
          <button className="button" style={{ width: "100%" }}>
            YENİ YÜKLE
          </button>
        </form>
      </DivBackground>
    </div>
  );
}
