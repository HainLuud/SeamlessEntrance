import pdf2image
import cv2
import sys


def pdfToJpeg(failinimi):
    pages = pdf2image.convert_from_path(failinimi, dpi=200)
    for page in pages:
        page.save('pilet_pildina.jpg', 'JPEG')


def qr_info():
    img = cv2.imread('pilet_pildina.jpg')
    detector = cv2.QRCodeDetector()
    data, bbox, straight_qrcode = detector.detectAndDecode(img)
    if bbox is not None:
        print(data)


failinimi = sys.argv[1]
# failinimi = 'ticket.pdf'
pdfToJpeg(failinimi)
qr_info()
