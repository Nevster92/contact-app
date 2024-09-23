import axios from 'axios'

export interface Contact {
  id?: number
  name?: string
  phone_number?: string
  email?: string
  picture?: string
}

export async function getContact(id: number): Promise<Contact | null> {
  try {
    const response = await axios.get<Contact>(`http://localhost:8080/contact/${id}`)
    return response.data
  } catch (error) {
    console.error('Error fetching contact:', error)
    return null
  }
}

export async function getContacts(): Promise<Contact[] | null> {
  try {
    const response = await axios.get<Contact[]>(`http://localhost:8080/contact`)
    return response.data
  } catch (error) {
    console.error('Error fetching contact:', error)
    return null
  }
}

export async function createNewContact(contact: Contact): Promise<Contact[] | null> {
  try {
    const response = await axios.post<Contact[]>(`http://localhost:8080/contact`, contact)
    return response.data
  } catch (error) {
    console.error('Error fetching contact:', error)
    return null
  }
}

export async function updateContact(contact: Contact): Promise<Contact[] | null> {
  try {
    const response = await axios.put<Contact[]>(`http://localhost:8080/contact`, contact)
    return response.data
  } catch (error) {
    console.error('Error fetching contact:', error)
    return null
  }
}

export async function deleteContact(contactId: number): Promise<boolean> {
  try {
    const response = await axios.delete<Contact[]>(`http://localhost:8080/contact/${contactId}`)
    return true
  } catch (error) {
    console.error('Error fetching contact:', error)
    return false
  }
}
