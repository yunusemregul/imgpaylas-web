import React, { useState } from "react";
import DivBackground from "../components/DivBackground";
import Header from "../components/Header";
import Input from "../components/Input";
import axios from "axios";
import Dropzone from "react-dropzone";

// TODO: tasarım belki revize edilebilir pek güzel değil

export default function Upload() {
  const [image, setImage] = useState();

  function handleSubmit(event) {
    event.preventDefault();

    if (!image) {
      console.log("fotograf secilmemis");
      return;
    }

    const formData = new FormData(event.target);

    formData.set("image", image, image.name);

    axios
      .post("/api/v1/image/upload", formData)
      .then((result) => {
        if (result.status === 200) {
          console.log(result); // TODO: başarılı yükleme ekranı göster
        }
      })
      .catch((error) => {
        console.log(error); // TODO: yüklenirken hata ekranı göster
      });
  }

  return (
    <div className="box" style={{ height: "auto" }}>
      <Header title="Yeni Yükleme" />
      <DivBackground backgroundColor="#444">
        <form style={{ margin: "20px" }} onSubmit={handleSubmit}>
          <Dropzone
            maxFiles={1}
            multiple={false}
            canCancel={false}
            accept=".jpeg,.jpg,.png"
            onDrop={(acceptedFiles) => {
              if (acceptedFiles.length === 0) return;

              let img = acceptedFiles[0];
              setImage(
                Object.assign(img, { preview: URL.createObjectURL(img) })
              );
            }}
          >
            {({ getRootProps, getInputProps, isDragActive }) => (
              <div {...getRootProps()} className="div-upload clickable">
                <input {...getInputProps()} id="image" name="image" />
                {image ? (
                  <img
                    src={image.preview}
                    style={{
                      maxWidth: "60%",
                      objectFit: "contain",
                    }}
                  />
                ) : (
                  <p style={{ alignSelf: "center" }}>
                    {!isDragActive &&
                      "Bu alana fotoğraf sürükle ya da tıklayarak seç"}
                    {isDragActive && "Fotoğraf bırakılabilir..."}
                  </p>
                )}
              </div>
            )}
          </Dropzone>
          <Input
            type="text"
            id="description"
            style={{
              border: "0px",
              borderRadius: "0px",
              width: "100%",
              backgroundColor: "#DFDFDF",
              textAlign: "center",
            }}
            placeholder="Açıklama"
          />
          <button
            className="button"
            style={{ width: "100%", borderRadius: "0px" }}
          >
            YÜKLE
          </button>
        </form>
      </DivBackground>
    </div>
  );
}
