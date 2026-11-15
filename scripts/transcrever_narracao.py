#!/usr/bin/env python3
"""Transcreve o audio com marcas de tempo para revisao editorial."""
import json
import os
from pathlib import Path
from faster_whisper import WhisperModel

ARQUIVO = Path("entrada/narracao.mp3")
SAIDA = Path("transcricao")
SAIDA.mkdir(parents=True, exist_ok=True)

def tempo_srt(segundos):
    total_ms = max(0, round(segundos * 1000))
    h, rem = divmod(total_ms, 3600000)
    m, rem = divmod(rem, 60000)
    s, ms = divmod(rem, 1000)
    return f"{h:02d}:{m:02d}:{s:02d},{ms:03d}"

def tempo_legivel(segundos):
    total_s = max(0, int(segundos))
    m, s = divmod(total_s, 60)
    return f"{m:02d}:{s:02d}"

if not ARQUIVO.is_file() or ARQUIVO.stat().st_size == 0:
    raise RuntimeError("Arquivo de audio ausente ou vazio.")

modelo = WhisperModel(
    "small",
    device="cpu",
    compute_type="int8",
    cpu_threads=max(2, min(4, os.cpu_count() or 2)),
)
segmentos_iterador, info = modelo.transcribe(
    str(ARQUIVO),
    language="pt",
    beam_size=5,
    vad_filter=True,
    condition_on_previous_text=False,
)
segmentos = []
for item in segmentos_iterador:
    texto = item.text.strip()
    if texto:
        segmentos.append({
            "inicio": round(item.start, 3),
            "fim": round(item.end, 3),
            "texto": texto,
        })
if not segmentos:
    raise RuntimeError("Nenhum trecho de fala foi transcrito.")

with (SAIDA / "transcricao_com_tempo.txt").open("w", encoding="utf-8") as f:
    for item in segmentos:
        f.write(f"[{tempo_legivel(item['inicio'])} - {tempo_legivel(item['fim'])}] {item['texto']}\n")

with (SAIDA / "transcricao_corrida.txt").open("w", encoding="utf-8") as f:
    f.write(" ".join(item["texto"] for item in segmentos) + "\n")

with (SAIDA / "legendas.srt").open("w", encoding="utf-8") as f:
    for i, item in enumerate(segmentos, 1):
        f.write(f"{i}\n{tempo_srt(item['inicio'])} --> {tempo_srt(item['fim'])}\n{item['texto']}\n\n")

with (SAIDA / "segmentos.json").open("w", encoding="utf-8") as f:
    json.dump({
        "idioma_informado": "pt",
        "idioma_detectado": info.language,
        "duracao_segundos": info.duration,
        "segmentos": segmentos,
    }, f, ensure_ascii=False, indent=2)

print(f"Transcritos {len(segmentos)} segmentos; duracao ~{info.duration:.1f}s")
print("Revisar nomes, termos tecnicos e trechos com fala pouco audivel antes do roteiro.")
